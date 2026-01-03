class Solution:
    def heightChecker(self, heights):
        expected = sorted(heights)
        return sum(1 for i, j in zip(expected, heights) if i != j)

def main():
    heights = [5,1,2,3,4]
    sol = Solution()
    print(sol.heightChecker(heights))

if __name__ == "__main__":
    main()
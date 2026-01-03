class Solution:
    def earliestTime(self, tasks):
        return min((x + y) for x, y in tasks)

def main():
    tasks = [[1,6],[2,3]]
    sol = Solution()
    print(sol.earliestTime(tasks))

if __name__ == "__main__":
    main()
class Solution:
    def largestAltitude(self, gain):
        result = [0]
        current = 0
        for i in gain:
            current += i
            result.append(current)
        return max(result)

def main():
    gain = [-5,1,5,0,-7]
    sol = Solution()
    print(sol.largestAltitude(gain))

if __name__ == "__main__":
    main()
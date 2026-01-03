import math

class Solution:
    def gcdOfOddEvenSums(self, n):
        cnt = 1
        odds = 0
        evens = 0
        for _ in range(n):
            odds += cnt
            evens += cnt + 1
            cnt += 2
        return math.gcd(odds, evens)

def main():
    n = 5
    sol = Solution()
    print(sol.gcdOfOddEvenSums(n))

if __name__ == "__main__":
    main()
class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x):
        n = sum(int(i) for i in list(str(x)))
        return n if x%n == 0 else -1

def main():
    x = 40
    sol = Solution()
    print(sol.sumOfTheDigitsOfHarshadNumber(x))

if __name__ == "__main__":
    main()
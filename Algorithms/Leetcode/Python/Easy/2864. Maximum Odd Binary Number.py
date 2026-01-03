class Solution:
    def maximumOddBinaryNumber(self, s):
        ones = s.count("1") - 1
        zeros = s.count("0")
        return "1" * ones + "0" * zeros + "1"

def main():
    s = "011010011001110001101"
    sol = Solution()
    print(sol.maximumOddBinaryNumber(s))

if __name__ == "__main__":
    main()
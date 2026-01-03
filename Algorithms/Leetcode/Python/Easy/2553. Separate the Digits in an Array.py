class Solution:
    def separateDigits(self, nums):
        return [int(digit) for num in nums for digit in str(num)]

def main():
    nums = [13,25,83,77]
    sol = Solution()
    print(sol.separateDigits(nums))

if __name__ == "__main__":
    main()
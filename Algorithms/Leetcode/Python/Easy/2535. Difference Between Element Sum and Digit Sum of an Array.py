class Solution:
    def differenceOfSum(self, nums):
        element_sum = sum(nums)
        digit_sum = 0
        for i in nums:
            if i < 10:
                digit_sum += i
            else:
                for j in str(i):
                    digit_sum += int(j)
        return abs(element_sum - digit_sum)

def main():
    nums = list(map(int,input().split()))
    print(Solution().differenceOfSum(nums))

if __name__ == "__main__":
    main()
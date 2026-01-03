class Solution:
    def addedInteger(self, nums1, nums2):
        return max(nums2) - max(nums1)

def main():
    nums1 = [2,6,4]
    nums2 = [9,7,5]
    sol = Solution()
    print(sol.addedInteger(nums1,nums2))

if __name__ == "__main__":
    main()
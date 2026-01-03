class Solution:
    def findDifference(self, nums1, nums2):
        s1 = set(nums1)
        s2 = set(nums2)
        return [list(s1-s2), list(s2-s1)]
    
def main():
    nums1 = [1,2,3]
    nums2 = [2,4,6]
    sol = Solution()
    print(sol.findDifference(nums1,nums2))

if __name__ == "__main__":
    main()
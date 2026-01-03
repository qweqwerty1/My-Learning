class Solution:
    def mergeArrays(self, nums1, nums2):
        result = []
        p1, p2 = 0, 0
        n1, n2 = len(nums1), len(nums2)

        while p1 < n1 and p2 < n2:
            id1, val1 = nums1[p1]
            id2, val2 = nums2[p2]

            if id1 < id2:
                result.append([id1, val1])
                p1 += 1
            elif id2 < id1:
                result.append([id2, val2])
                p2 += 1
            else:
                result.append([id1, val1 + val2])
                p1 += 1
                p2 += 1
        
        if p1 < n1:
            result.extend(nums1[p1:])
        if p2 < n2:
            result.extend(nums2[p2:])
        
        return result

def main():
    nums1 = [[1,2],[2,3],[4,5]]
    nums2 = [[1,4],[3,2],[4,1]]
    sol = Solution()
    print(sol.mergeArrays(nums1, nums2))

if __name__ == "__main__":
    main()
class Solution:
    def pivotArray(self, nums, pivot):
        low_part = []
        eq_part = []
        high_part = []

        for i in nums:
            if i < pivot:
                low_part.append(i)
            elif i > pivot:
                high_part.append(i)
            else:
                eq_part.append(i)
        
        low_part.extend(eq_part)
        low_part.extend(high_part)

        return low_part

def main():
    nums = [-3,4,3,2]
    pivot = 3
    sol = Solution()
    print(sol.pivotArray(nums, pivot))

if __name__ == "__main__":
    main()
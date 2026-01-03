class Solution:
    def sumOddLengthSubarrays(self, arr):
        n = len(arr)
        result = 0
        for i in range(n):
            left = i + 1
            right = n - i
            total = left * right
            odd_count = (total + 1)//2
            result += arr[i] * odd_count
        return result


def main():
    sol = Solution()
    arr = [1,4,2,5,3]
    print(sol.sumOddLengthSubarrays(arr))

if __name__ == "__main__":
    main()
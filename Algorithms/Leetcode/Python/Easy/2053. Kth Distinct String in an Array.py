from collections import Counter

class Solution:
    def kthDistinct(self, arr, k):
        freq_arr = Counter(arr)
        result = [key for key, value in freq_arr.items() if value == 1]
        return result[k-1] if len(result) >= k else ""

def main():
    arr = ["a","b","a"]
    k = 3
    sol = Solution()
    print(sol.kthDistinct(arr, k))

if __name__ == "__main__":
    main()
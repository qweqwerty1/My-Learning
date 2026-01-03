class Solution:
    def restoreString(self, s, indices):
        n = len(s)
        result = [None] * n
        for i, j in enumerate(indices):
            result[j] = s[i]
        return "".join(result)

def main():
    s = input()
    indices = list(map(int,input().split()))
    print(Solution().restoreString(s, indices))

if __name__ == "__main__":
    main()
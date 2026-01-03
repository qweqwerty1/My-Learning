class Solution:
    def pivotInteger(self, n):
        total = n*(n+1)//2
        root = int(total**0.5)
        return root if total == root * root else -1

def main():
    n = 8
    sol = Solution()
    print(sol.pivotInteger(n))

if __name__ == "__main__":
    main()
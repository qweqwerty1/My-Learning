class Solution:
    def diagonalSum(self, mat):
        result = 0
        n = len(mat)
        for i in range(n):
            result += mat[i][i] + mat[i][n - 1 - i]
        if n%2 != 0:
            result -= mat[n//2][n//2]
        return result

def main():
    mat = [[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
    sol = Solution()
    print(sol.diagonalSum(mat))    

if __name__ == "__main__":
    main()
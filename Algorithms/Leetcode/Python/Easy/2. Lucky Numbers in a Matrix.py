class Solution:
    def luckyNumbers(self, matrix):
        result = []
        M = len(matrix[0])
        N = len(matrix)

        row_mins = set()
        for row in matrix:
            row_mins.add(min(row))
        
        for i in range(M):
            col_max = 0
            for j in range(N):
                col_max = max(col_max, matrix[j][i])
            if col_max in row_mins:
                result.append(col_max)
                break
        
        return result
    
def main():
    matrix = [[3,7,8],[9,11,13],[15,16,17]]
    sol = Solution()
    print(sol.luckyNumbers(matrix))

if __name__ == "__main__":
    main()
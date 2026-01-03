class Solution:
    def selfDividingNumbers(self, left, right):
        result = []
        for num in range(left, right+1):
            for i in str(num):
                if int(i) == 0 or num%int(i) != 0:
                    break
            else:
                result.append(num)    
        return result    

def main():
    left = 47
    right = 85
    sol = Solution()
    print(sol.selfDividingNumbers(left, right))

if __name__ == "__main__":
    main()
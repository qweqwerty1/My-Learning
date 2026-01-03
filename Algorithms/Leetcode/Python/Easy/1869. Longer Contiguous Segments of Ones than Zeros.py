class Solution:
    def checkZeroOnes(self, s):
        zero_cnt = max(len(i) for i in s.split("1"))
        one_cnt = max(len(i) for i in s.split("0"))
        return one_cnt > zero_cnt
        
def main():
    sol = Solution()
    s = "1111110001100000"
    print(sol.checkZeroOnes(s))

if __name__ == "__main__":
    main()
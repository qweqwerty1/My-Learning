class Solution:
    def digitSum(self, s, k):
        while len(s) > k:
            n = len(s)
            sep_s = [s[i:i+k] for i in range(0,n,k)]
            result = []
            for num in sep_s:
                add_num = sum(int(x) for x in num)
                result.append(str(add_num))
            s = "".join(result)
        
        return s

def main():
    s = "01234567890"
    k = 2
    sol = Solution()
    print(sol.digitSum(s,k))

if __name__ == "__main__":
    main()
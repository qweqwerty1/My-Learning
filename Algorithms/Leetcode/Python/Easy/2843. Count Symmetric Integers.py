class Solution:
    def countSymmetricIntegers(self, low, high):
        result = 0
        for i in range(low, high+1):
            s = str(i)
            if len(s) == 2:
                if i%11 == 0:
                    result += 1
            elif len(s) == 4:
                front_num = sum(map(int,s[:2]))
                back_num = sum(map(int,s[2:]))
                if front_num == back_num:
                    result += 1
        return result

def main():
    low = 1
    high = 10000
    sol = Solution()
    print(sol.countSymmetricIntegers(low,high))

if __name__ == "__main__":
    main()
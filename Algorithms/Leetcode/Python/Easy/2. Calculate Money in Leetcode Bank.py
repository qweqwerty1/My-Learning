class Solution:
    def totalMoney(self, n):
        start_p, end_p = 1, 7
        cnt = 1
        result = 0

        for _ in range(n):
            result += cnt
            if cnt == end_p:
                start_p += 1
                end_p += 1
                cnt = start_p
            else : cnt += 1

        return result

def main():
    n = 7
    sol = Solution()
    print(sol.totalMoney(n))

if __name__ == "__main__":
    main()
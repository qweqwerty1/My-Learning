class Solution:
    def isBalanced(self, num):
        sum_odd = 0
        sum_even = 0
        for i, n in enumerate(num):
            if i%2 == 0:
                sum_even += int(n)
            else:
                sum_odd += int(n)
        return sum_odd == sum_even

def main():
    num = "24123"
    sol = Solution()
    print(sol.isBalanced(num))

if __name__ == "__main__":
    main()
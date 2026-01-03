class Solution:
    def largestInteger(self, num):
        odd_nums = []
        even_nums = []
        parity_list = []

        for i in str(num):
            if int(i) % 2 == 0:
                parity_list.append("even")
                even_nums.append(i)
            else:
                parity_list.append("odd")
                odd_nums.append(i)

        even_nums.sort()
        odd_nums.sort()

        result = []

        for i in parity_list:
            if i == "odd":
                result.append(odd_nums.pop())
            else:
                result.append(even_nums.pop())

        return int("".join(result))

def main():
    num = 65875
    sol = Solution()
    print(sol.largestInteger(num))

if __name__ == "__main__":
    main()
class Solution:
    def maximum69Number (self, num):
        list_num = list(str(num))
        if "6" in list_num:
            list_num[list_num.index("6")] = "9"
        return int("".join(list_num))
            
def main():
    num = 9969
    print(Solution().maximum69Number(num))

if __name__ == "__main__":
    main()
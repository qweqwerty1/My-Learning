class Solution:
    def replaceDigits(self, s):
        prev_word = ""
        result = ""

        for i in s:
            if i.isalpha():
                prev_word = i
                result += i
            else:
                result += chr(ord(prev_word) + int(i))
        return result
    
def main():
    s = "a1b2c3d4e"
    sol = Solution()
    print(sol.replaceDigits(s))

if __name__ == "__main__":
    main()
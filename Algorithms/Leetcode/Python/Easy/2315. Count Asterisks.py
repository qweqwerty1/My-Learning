class Solution:
    def countAsterisks(self, s):
        s_list = s.split("|")
        return "".join(s for i, s in enumerate(s_list) if i%2 == 0).count("*")

def main():
    s = "yo|uar|e**|b|e***au|tifu|l"
    sol = Solution()
    print(sol.countAsterisks(s))

if __name__ == "__main__":
    main()
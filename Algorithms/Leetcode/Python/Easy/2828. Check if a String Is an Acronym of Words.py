class Solution:
    def isAcronym(self, words, s):
        if len(words) != len(s):
            return False
        for word, ch in zip(words,s):
            if word[0] != ch:
                return False
        return True

def main():
    words = ["an","apple"]
    s = "aa"
    sol = Solution()
    print(sol.isAcronym(words,s))

if __name__ == "__main__":
    main()
        
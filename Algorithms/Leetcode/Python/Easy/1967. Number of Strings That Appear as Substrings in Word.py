class Solution:
    def numOfStrings(self, patterns, word):
        return sum(1 for i in patterns if i in word)

def main():
    patterns = ["a","abc","bc","d"] 
    word = "abc"
    sol = Solution()
    print(sol.numOfStrings(patterns,word))

if __name__ == "__main__":
    main()
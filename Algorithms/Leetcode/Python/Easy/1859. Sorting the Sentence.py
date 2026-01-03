class Solution:
    def sortSentence(self, s):
        result = []
        list_s = s.split()
        list_s = sorted(list_s, key=lambda x : x[-1])
        for i in list_s:
            word = i[:-1]
            result.append(word)
        return " ".join(result)
    
def main():
    sol = Solution()
    s = "is2 sentence4 This1 a3"
    print(sol.sortSentence(s))

if __name__ == "__main__":
    main()
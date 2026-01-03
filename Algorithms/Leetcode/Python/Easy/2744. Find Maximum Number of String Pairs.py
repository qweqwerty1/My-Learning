class Solution:
    def maximumNumberOfStringPairs(self, words):
        seen = set()
        result = 0
        for word in words:
            word = "".join(sorted(word))
            if word in seen:
                result += 1
            else:
                seen.add(word)
        return result

def main():
    words = ["aa", "ab", "ba", "cd", "dc"]
    sol = Solution()
    print(sol.maximumNumberOfStringPairs(words))

if __name__ == "__main__":
    main()
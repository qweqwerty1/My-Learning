class Solution:
    def uniqueMorseRepresentations(self, words):
        trans = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        seen = set()
        for word in words:
            morse = "".join(trans[ord(c) - ord('a')] for c in word)
            seen.add(morse)
        return len(seen)


def main():
    words = ["gin","zen","gig","msg"]
    sol = Solution()
    print(sol.uniqueMorseRepresentations(words))

if __name__ == "__main__":
    main()
class Solution:
    def kthCharacter(self, k):
        cnt = 1
        words = ["a"]

        while cnt < k:
            for word in words[:]:
                ord_word = ord(word) + 1 if ord(word) < ord("z") else ord("a")
                words.append(chr(ord_word))
            cnt = cnt << 1

        word = "".join(words)
        return word[k-1]

def main():
    k = 10
    sol = Solution()
    print(sol.kthCharacter(k))

if __name__ == "__main__":
    main()
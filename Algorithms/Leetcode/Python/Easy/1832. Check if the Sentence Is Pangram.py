class Solution:
    def checkIfPangram(self, sentence):
        freq = [0] * 26
        for i in sentence:
            freq[ord(i)-ord("a")] += 1
        return all(freq)

def main():
    sentence = "leetcode"
    print(Solution().checkIfPangram(sentence))

if __name__ == "__main__":
    main()
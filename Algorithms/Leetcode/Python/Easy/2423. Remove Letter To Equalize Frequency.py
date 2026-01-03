class Solution:
    def equalFrequency(self, word):
        freq = Counter(word)
        for i in list(freq.keys()):
            freq[i] -= 1
            if freq[i] == 0:
                del freq[i]
            if len(set(freq.values())) == 1:
                return True
            freq[i] += 1
        return False
        
def main():
    word = "cccd"
    print(Solution().equalFrequency(word))

if __name__ == "__main__":
    main()

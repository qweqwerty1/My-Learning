class Solution:
    def firstPalindrome(self, words):
        for i in words:
            if i == i[::-1]:
                return i
        return ""

def main():
    
if __name__ == "__main__":
    main()
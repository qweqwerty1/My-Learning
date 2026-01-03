class Solution:
    def freqAlphabets(self, s):
        result = []
        i = 0
        n = len(s)

        while i < n:
            if i + 2 < n and s[i+2] == "#":
                x = int(s[i:i+2])
                result.append(chr(x + 96))
                i += 3
            else:
                x = int(s[i])
                result.append(chr(x + 96))
                i += 1
        
        return "".join(result)

def main():
    s = "1326#"
    sol = Solution()
    print(sol.freqAlphabets(s))

if __name__ == "__main__":
    main()
class Solution:
    def reverseWords(self, s):
        s_list = [i[::-1] for i in s.split()]
        return " ".join(s_list)

def main():
    s = "Let's take LeetCode contest"
    sol = Solution()
    print(sol.reverseWords(s))
    
if __name__ == "__main__":
    main()
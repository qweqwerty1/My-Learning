class Solution:
    def countSeniors(self, details):
        return sum(1 for d in details if int(d[-4:-2]) > 60)

def main():
    details = ["7868190130M7522","5303914400F9211","9273338290F6010"]
    sol = Solution()
    print(sol.countSeniors(details))

if __name__ == "__main__":
    main()
class Solution:
    def cellsInRange(self, s):
        s_list = s.split(":")
        r_start = s_list[0][1]
        r_end = s_list[1][1]
        c_start = s_list[0][0]
        c_end = s_list[1][0]

        result = []
        for i in range(ord(c_start), ord(c_end) + 1):
            for j in range(int(r_start), int(r_end) + 1):
                result.append(chr(i)+str(j))
        return result
    
def main():
    s = "A1:F1"
    print(Solution().cellsInRange(s))

if __name__ == "__main__":
    main()
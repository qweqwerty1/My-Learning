class Solution:
    def concatHex36(self, n):
        if n == 0:
            return 0
        
        BASE36_CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        base = 36
        hex_num = hex(n**2)[2:].upper()
        b36_num = n**3
        result = ""

        while b36_num > 0:
            reminder = b36_num % base 
            result = BASE36_CHARS[reminder] + result
            b36_num //= base

        return hex_num + result

def main():
    n = 36
    sol = Solution()
    print(sol.concatHex36(n))

if __name__ == "__main__":
    main()
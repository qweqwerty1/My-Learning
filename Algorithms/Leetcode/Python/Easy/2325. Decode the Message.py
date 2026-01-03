class Solution:
    def decodeMessage(self, key, message):
        alpha_dict = {" " : " "}
        current_num = ord("a")

        for i in key:
            if i not in alpha_dict:
                alpha_dict[i] = chr(current_num)
                current_num += 1

        result = [alpha_dict[i] for i in message]
        return "".join(result)
    
def main():
    key = "the quick brown fox jumps over the lazy dog"
    message = "vkbs bs t suepuv"
    print(Solution().decodeMessage(key, message))

if __name__ == "__main__":
    main()
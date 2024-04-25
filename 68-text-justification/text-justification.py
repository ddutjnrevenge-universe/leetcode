class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        result = []
        current_line = []
        current_length = 0

        for word in words:
            # Check if the current word can fit in the current line
            if current_length + len(word) + len(current_line) > maxWidth:
                # Distribute the extra spaces
                num_spaces = maxWidth - current_length
                if len(current_line) == 1:
                    # If there is only one word in the line, left-justify
                    result.append(current_line[0] + ' ' * num_spaces)
                else:
                    # Calculate spaces and extra spaces
                    spaces, extra_spaces = divmod(num_spaces, len(current_line) - 1)
                    line = ''
                    for i in range(len(current_line) - 1):
                        line += current_line[i] + ' ' * (spaces + (1 if i < extra_spaces else 0))
                    line += current_line[-1]
                    result.append(line)

                # Reset the current line and length
                current_line = []
                current_length = 0

            # Add the current word to the current line
            current_line.append(word)
            current_length += len(word)

        # Handle the last line
        result.append(' '.join(current_line).ljust(maxWidth))

        return result



            
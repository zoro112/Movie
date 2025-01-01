# Python code to edit a file

file_path = 'C:/Users/Said/Desktop/Win7/Movie/NewFile.txt'

# Open the file in append mode
with open(file_path, 'a') as file:
    # Write some text to the file
    file.write('This is a new line of text.\n')
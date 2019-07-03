def count_loads(read_path, write_path):
    file_read = open(read_path, "r")
    file_write = open(write_path, "a")
    load_count = 0
    lst = []
    line = file_read.readline() 
    while line:
        lst = list(line.split(","))
        load_count = str(len(lst))
        file_write.write(load_count + "\n")
        line = file_read.readline()
    file_write.close()
    file_read.close()

def format_admin_data(read_path, write_path):
    file_read = open(read_path, "r")
    file_write = open(write_path, "a")
    lst = []
    line = file_read.readline()
    date = ""
    while line:
        lst = list(line.split(","))
        counter = 1
        for s in lst:
            if s[12] == 0:
                date = s[1:11] + s[13:]
                if counter == 3:
                    file_write.write(date)
                else:
                    file_write.write(date + ",")
            else:
                date = s[1:11] + s[12:]
                if counter == 3:
                    file_write.write(date)
                else:
                    file_write.write(date + ",")
            counter += 1
        line = file_read.readline()
    file_write.close()
    file_read.close()


def main():
    file_read = input("Enter the CSV file to format:")
    directory = input("Enter the output directory:")
    format_or_count = input("Enter 'format' or 'count' for the functionality to be preformed")
    if format_or_count != "format" and format_or_count != "count":
        correct_input = False
    while correct_input == False:
        format_or_count = input("Please enter 'format' or 'count' depending on which functonality you want to be preformed:")
        if format_or_count == "format" or format_or_count == "count":
            correct_input = True
    if format_or_count == "format":
        format_admin_data(file_read, directory)
    else:
        count_loads(file_read, directory)

main()






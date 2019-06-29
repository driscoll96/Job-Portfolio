#### Unit Testing found at bottom of file

import turtle
import math

wn = turtle.Screen()
othello = turtle.Turtle()
othello.speed(200)
move_list = []
total_moves = 0
white_no_turn = 0
black_no_turn = 0


#### Purpose
# This function creates a 8x8 matrix by putting 8 lists all filled wth "" in an empty list
#### Signature
# board_matrix :: (List) => Void
#### Example
# board_matrix(move_list) ==> move_list = [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
#                                           ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
#                                           ['', '', '', '', '', '', '', ''], ['', '','', '', '', '', '', ''], 
#                                           ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']]

def board_matrix(move_list):
    for r in range(0, 8):
        move_list.append([])
        for c in range(0, 8):
            move_list[r].append("")


#### Purpose
# This function uses the turtle python module to draw a 8x8 representation of board game
# with green fill and black outline and 4 starting tiles in the center squares. It also
# places the strings "black" and "white" in the matrix board where the tiles are on the 
# image board.
#### Signature  
# draw_board :: (List) => Void
#### Example
# draw_board(move_list) => Draws an 8x8 matrix board with 2 black and 2 whites in the middle of the board.
#                          move_list = [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
#                                        ['', '', '', '', '', '', '', ''], ['', '', '', 'white', 'black', '', '', ''], 
#                                        ['', '', '', 'black', 'white', '', '', ''], ['', '','', '', '', '', '', ''], 
#                                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']]         

def draw_board(move_list):
    othello.color("black", "forest green")
    othello.setposition(-150, 150)
    othello.begin_fill()
    for s in range(4):
        othello.forward(304)
        othello.right(90)
    othello.end_fill()

    othello.right(90)
    for l in range(1, 9):
        othello.setposition((l*38)-150, 150)
        othello.pendown()
        othello.forward(304)
        othello.penup()

    othello.left(90)
    for l in range(1, 9):
        othello.setposition(-150, 150-l*38)
        othello.pendown()
        othello.forward(304)
        othello.penup()

    for r in range(3, 5):
        for c in range(3, 5):
            othello.begin_fill()
            if r == 3 and c == 4 or r == 4 and c == 3:
                tile_color = "black"
                move_list[r][c] = tile_color
                othello.color("black", tile_color)
            else:
                tile_color = "white"
                move_list[r][c] = tile_color
                othello.color("black", tile_color)
            othello.setposition((19+(c)*38)-150, 150-(r+1)*38)
            othello.pendown()
            othello.circle(19)
            othello.end_fill()
            othello.penup()


#### Purpose
# This function takes the coordinates of screen wherever the users clicks on it and
# converts the float coordinates into a integer number from 0-7 based on the clicks
# location on the game board. It, then calls the check_valid_move with the converted
# coordinates to see if the user's click is a valid move. If it is a valid move, then 
# the function player_move is called to draw the new tiles on the image board.
#### Signature
# human_input :: (Float, Float) => Void
#### Example
# human_input(-130.50, 20.25) => input_col = 1, input_row = 3
# human_input(-30.75, 67.89) => input_col = 3, input_row = 2

def human_input(x, y):
    global black_no_turn
    tile_color = othello.color()[1]
    if tile_color == "black":
        othello.goto(x, y)
        input_col = math.floor((abs(150+othello.xcor())/38))
        input_row = math.floor((abs(othello.ycor()-150)/38))
        flipped_list = check_valid_move(input_col, input_row)
        if len(flipped_list) > 1:
            player_move(flipped_list)
            black_no_turn = 0


#### Purpose
# This function checks whether a move is valid based on the column and row numbers
# inputed. It checks the index in the board matrix, if a tiles was placed there,
# would there be opposing tiles flipped. The function looks at all surrounding squares to
# see if any opposing tiles are "sandwiched" between the players tiles and returns a nested 
# list with the coordinates of any flipped tiles, including the square where the tile would be placed.
#### Signature
# check_valid_move :: (Integer, Integer) => List
#### Example
# check_valid_move(3, 6) => [[3, 5], [3, 4], [3, 6]]
# check_valid_move(2, 4) => [[2, 4]]
# check_valid_move(4, 9) => []

def check_valid_move(x, y):
    tile_color = othello.color()[1]
    flipped_list = []
    input_col = x
    input_row = y
    x_check = 0
    y_check = 0
    if move_list[input_row][input_col] == "":
        for r in range(input_row-1, input_row+2):
            for c in range(input_col-1, input_col+2):
                if (-1 < r < 8 and -1 < c < 8) and not (r == input_row and c == input_col):
                    if move_list[r][c] != tile_color and move_list[r][c] != "":
                        x_check = c - input_col
                        y_check = r - input_row
                        tile_line_counter = 0
                        temp_r = r
                        temp_c = c
                        while -1 < temp_r < 8 and -1 < temp_c < 8:
                            if move_list[temp_r][temp_c] == "":
                                break
                            elif move_list[temp_r][temp_c] == tile_color:
                                for t in range(0, tile_line_counter):
                                    flipped_coord = []
                                    temp_r -= y_check
                                    temp_c -= x_check
                                    flipped_coord.append(temp_c)
                                    flipped_coord.append(temp_r)
                                    flipped_list.append(flipped_coord)
                                break
                            else:
                                tile_line_counter +=1
                                temp_r += y_check
                                temp_c += x_check
    flipped_list.append([input_col, input_row])
    return flipped_list


#### Purpose
# This function takes a list of flipped tiles from a particular move and draws
# the new tile images on the image board.
#### Signature
# player_move :: List => Void
#### Example
# player_move([[3, 5], [3, 4], [3, 6]]) => Draws three tiles in the squares based 
#                                          on these coordinates.
# player_move([[2, 4], [3, 5]]) => Draws two tiles in the squares based 
#                                  on these coordinates.

def player_move(flipped_list):
    tile_color = othello.color()[1]
    for t in flipped_list:
        input_col = t[0]
        input_row = t[1]
        move_list[input_row][input_col] = tile_color
        othello.setposition((19+(input_col)*38)-150, 150-(input_row+1)*38)
        othello.begin_fill()
        othello.pendown()
        othello.circle(19)
        othello.end_fill()
        othello.penup()
    global total_moves
    total_moves += 1


#### Purpose
# This function uses the check_valid_move function to look at all the squares in
# the game board which are unoccupied and see which ones will lead to a valid 
# move if a tile of the player's color is placed there. The function returns
# a nested list of coordinates of the valid moves, along with the amount of
# tiles that will be flipped from that move.
#### Signature
# find_valid_moves :: () => List
#### Example
# find_valid_moves() => [[3, 4, 6], [4, 2, 3]]
# find_valid_moves() => [[3, 4, 2], [6, 2, 3], [7, 1, 3]]
# find_valid_moves() => []


def find_valid_moves():
    valid_moves_list = []
    for i in range(0, 8):
        for j in range(0, 8):
            if move_list[i][j] == "":
                check_move = len(check_valid_move(j, i))
                if check_move > 1:
                    valid_move = []
                    valid_move.append(j)
                    valid_move.append(i)
                    valid_move.append(check_move)
                    valid_moves_list.append(valid_move)
    return valid_moves_list


#### Purpose
# This function acts as the computer AI player that finds all valid moves and chooses
# the move that results in the most tiles flipped. The mechanics of the code is further
# discussed in the text file, AI.txt.
#### Signature
# computer_player :: () => Void
#### Example
# computer_player() => Calls valid_moves_list and picks the move: (3, 5) because it flips
#                      5 tiles which is the most highest possible flips. Then, player_move(3, 5)
#                      is called to draw the flipped tiles.


def computer_player():
    valid_moves_list = find_valid_moves()
    if len(valid_moves_list) < 1:
        global total_moves
        total_moves += 1
        global white_no_turn
        white_no_turn = 1
    else:
        most_flipped = 0
        best_move = [0,0]
        for m in valid_moves_list:
            if m[2] > most_flipped:
                most_flipped = m[2]
                best_move[0] = m[0]
                best_move[1] = m[1]
        flipped_list = check_valid_move(best_move[0], best_move[1])
        player_move(flipped_list)
        white_no_turn = 0


#### Purpose
# This function checks the matrix board, move_list, to see if there are any empty
# spaces left.
#### Signature
# end_indicator :: () => Boolean
#### Example
# end_indicator() => True
# end_indicator() => False

def end_indicator():
    for i in move_list:
        for j in i:
            if j == "":
                return True
    return False
    

#### Purpose
# The function acts as the engine behind the board as it tracks turns, calls functions
# based on who's turn it is, and determines if the game is finished. It also determines
# if the user has a valid move to play and adds 1 to the total_moves counter if not.
#### Signature
# player_turn :: () => Void
#### Example
# playerturn() => if total_moves == 2, then human_input is called
# player_turn() => if total_moves == 3, then computer_player is called
# player_turn() => if end_indicator() == False, then the screen closes
# player_turn() => if white_no_turn == 1 and black_no_turn == 1, then
#                  the screen closes

def player_turn():
    global total_moves
    global black_no_turn
    while end_indicator() == True and (white_no_turn == 0 or black_no_turn == 0):
        if (total_moves%2) == 0:
            othello.color("black", "black")
            if len(find_valid_moves()) < 1:
                total_moves += 1
                black_no_turn = 1
            else:
                wn.onscreenclick(human_input)
        else:
            othello.color("black", "white")   
            computer_player()
    wn.bye()


#### Purpose
# This function announces the winner of the game by counting the number of tiles of
# of each color and comparing the two to see which player won. It prints a message
# stating the winner and the number of tiles they had. The function also records
# the name of the user and their tile count in a seperate txt file called Scores.txt.
#### Signature
# record_score :: (String, String) => Void
#### Example
# record_score("Scores.txt", "Cole") => "Cole 35" is appended to Scores.txt
# record_score("Scores.txt", "Lebron James") => "Lebron James 50" is appended to Scores.txt         

def record_score(file_path, name):
    black_count = 0
    white_count = 0
    for i in move_list:
        for j in i:
            if j == "black":
                black_count += 1
            elif j == "white":
                white_count += 1
    if black_count > white_count:
        print("Black wins with a tile count of:", black_count)
    elif white_count > black_count:
        print("White wins with a tile count of:", white_count)
    else:
        print("Draw!")
    file = open(file_path, "r")
    first_char = file.read(1)
    if not first_char:
        file.close()
        file = open(file_path, "a")
        file.write(name + " " + str(black_count) + "\n")
        file.close()
    else:
        file = open(file_path, "r")
        line = file.readline()
        highest_score = int(line[len(line)-3:len(line)-1])
        file.close()
        if black_count > highest_score:
            append_copy = open(file_path, "r")
            original_text = append_copy.read()
            append_copy.close()
            append_copy = open(file_path, "w")
            append_copy.write(name + " " + str(black_count) + "\n")
            append_copy.write(original_text)
            append_copy.close()
        else:
            file = open(file_path, "a")
            file.write(name + " " + str(black_count) + "\n")
            file.close()
    return (black_count, white_count)



def main():
    board_matrix(move_list)
    draw_board(move_list)
    player_turn()
    path = "/Users/User/OneDrive/Comp Sci Stuff/student_repo_cdriscoll/HW 7/Scores.txt"
    input_name = input("Enter Your Name")
    record_score(path, input_name)

main()


#### Tests
# Make sure to comment out main() before performing tests, as well as only do the tests one by one.

def test_board_matrix():
    board_matrix(move_list)
    assert(move_list == [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '','', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']])

# test_board_matrix()

def test_draw_board():
    board_matrix(move_list)
    draw_board(move_list)
    assert(move_list == [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', 'white', 'black', '', '', ''], 
                        ['', '', '', 'black', 'white', '', '', ''], ['', '','', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']])

def test_check_valid_move():
    assert(check_valid_move(3, 2) == [[3, 3], [3, 2]])
    assert(check_valid_move(1, 1) == [[1, 1]])

# test_check_valid_move()

def test_player_move():
    board_matrix(move_list)
    player_move([[3, 2], [4, 3]])
    assert(move_list == [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
                        ['', '', '', 'black', '', '', '', ''], ['', '', '', '', 'black', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '','', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']])

# test_player_move()

def test_computer_player():
    board_matrix(move_list)
    draw_board(move_list)
    computer_player()
    assert(move_list == [['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', 'white', 'white', 'white', '', ''], 
                        ['', '', '', 'black', 'white', '', '', ''], ['', '','', '', '', '', '', ''], 
                        ['', '', '', '', '', '', '', ''], ['', '', '', '', '', '', '', '']])

# test_board_matrix()

def test_end_indicator():
    board_matrix(move_list)
    draw_board(move_list)
    assert(end_indicator() == True)

# test_end_indicator()

def test_player_turn():
    board_matrix(move_list)
    draw_board(move_list)
    player_turn()
    assert(othello.color()[1] == "black")
    global total_moves
    total_moves += 1
    assert(othello.color()[1] == "white")

# test_player_turn()

def test_record_score():
    board_matrix(move_list)
    draw_board(move_list)
    path = "/Users/User/OneDrive/Comp Sci Stuff/student_repo_cdriscoll/HW 7/Scores.txt"
    assert(record_score(path, "Cole") == (2, 2))

# test_record_score
    
    













                











    
    

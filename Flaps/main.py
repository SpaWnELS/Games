import random
import pygame
import sys
from pygame.locals import *

pygame.init()

DISPLAY = pygame.display.set_mode((500, 400), 0, 32)
font = pygame.font.Font('media/Antonio-VariableFont_wght.ttf', 70)

# Colours
white = (255, 255, 255)
blue = (0, 0, 255)
gray = (100, 100, 100)


def play():
    # Speed variables
    velocity = pygame.Vector2()
    velocity.xy = 2, 0
    acceleration = 0.1
    y_increase = -3
    y = 100
    x = 100

    # Other variables
    dead = False
    points = 5
    start_time = pygame.time.get_ticks()

    # Images
    bg = pygame.image.load('media/bg.png').convert()
    player = pygame.image.load('media/Fish.png')
    player_right = pygame.transform.scale(player, (80, 80))
    player_left = pygame.transform.flip(player_right, True, False)
    player = player_right
    bar = pygame.image.load('media/bar.png')
    bar = pygame.transform.scale(bar, (40, 200))

    # Bar values
    x_bar = 230
    y_bar = random.randint(5, 190)
    next_y_bar = random.randint(10, 190)

    while True:
        now = pygame.time.get_ticks()

        # Getting velocity
        y += velocity.y
        x += velocity.x
        velocity.y += acceleration

        # Boxes
        bar_box = pygame.Rect(x_bar + 5, y_bar + 13, 25, 142)

        if player == player_right:
            player_box = pygame.Rect(x, y + 10, 60, 80)
        else:
            player_box = pygame.Rect(x + 20, y + 13, 60, 50)

        # Crashes
        if x + 60 > DISPLAY.get_width() or x < 0:
            velocity.x = velocity.x * -1
            y_bar = next_y_bar
            next_y_bar = random.randint(10, 190)
            points += 1
            next_y_bar = random.randint(5, 190)
            if velocity.x > 0:
                current_player = player_right
            else:
                current_player = player_left

        if y < -20 or y - 60 > DISPLAY.get_height():
            dead = True

        if player_box.colliderect(bar_box):
            if now - start_time > 1500:
                points -= 3
                start_time = now

        # Time Punishment
        if now - start_time > 5000:
            velocity.x = velocity.x * 1.2
            acceleration *= 1.2
            start_time = now
            print('Speed: ' + str(abs(velocity.x)))

        keys = pygame.key.get_pressed()
        if keys[pygame.K_SPACE]:
            velocity.y = y_increase

        if not dead:
            # Drawing screen
            score = font.render(str(points), True, white)
            DISPLAY.blit(bg, (0, 0))
            DISPLAY.blit(player, (x, y))
            DISPLAY.blit(bar, (x_bar, y_bar))
            DISPLAY.blit(score, (10, 0))
            pygame.draw.rect(DISPLAY, blue, (x_bar + 3, next_y_bar + 20, 31, 160), 1)

        if points > 0:
            dead = False

        else:
            pygame.quit()
            sys.exit()

        # Quit
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()

        pygame.display.update()
        pygame.time.delay(10)


def draw_screen():
    title = font.render('Flaps by Eliot', True, white)
    prompt = font.render('Press Space to continue', True, white)

    DISPLAY.blit(title, (200, 150))
    DISPLAY.blit(prompt, (200, 300))

    keys = pygame.key.get_pressed()
    if keys[pygame.K_SPACE]:
        exit()


def main():
    draw_screen()
    play()


if __name__ == '__main__':
    main()

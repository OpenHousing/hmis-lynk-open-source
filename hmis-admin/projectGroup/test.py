from simplecrypt import encrypt, decrypt


if __name__ == '__main__':
    plaintext = "P@ssw0rd!"
    ciphertext = encrypt('password', plaintext)

    print ciphertext

    #password = "sc g&]�3�@��T�~~���F�����mM�h�Ee�^C�K������}4E��]���n̡�9���^Q�	m�"

    text = decrypt('password', ciphertext)

    print text


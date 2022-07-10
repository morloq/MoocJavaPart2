/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Change {
    private char fromCharacter;
    private char toCharacter;
    public Change(char fromCharacter, char toCharacter)
    {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString)
    {
        char[] characters = characterString.toCharArray();
        for(int i = 0; i < characters.length; i++)
        {
            if(characters[i] == fromCharacter)
            {
                characters[i] = toCharacter;
            }
        }
        characterString = String.valueOf(characters);
        
        return characterString;
    }
}
nashville
=========

This is a Java program to allow songwriters to use the Nashville Number System with the ChordPro format.

The Nashville Number System uses "scale degrees" to determine chords.

Here's a line from a ChordPro file:

    [C]Twinkle, twinkle, [F]little [C]star,

In this line, we have two chords: C and F. F is the "fourth degree" of the C major scale, with C being the "first degree."

Therefore, in the Nashville Number System, one would write that line like so:

    [I]Twinkle, twinkle, [IV]little [I]star,

This means that instead of having musicians convert keys in their heads for the entire song, the song is written such that all you have to tell them is "I is C," and the rest falls into place.

The only concern is that this converts into actual ChordPro format; you'd hand this program the Nashville version and it would spit out the ChordPro version, without the Nashville numbering. 

Give me time; I'm working on that.

build
=====

1. Install Maven
1. mvn package

The built package will be in the `target` directory of the source code.

run
===

Assuming the built jar file is `$NASHVILLE_JAR`, using the application is simple.

    java -jar $NASHVILLE_JAR [-capo 0] [-mode major] [-key C] file list

There are currently two modes supported, each with two names: `major`, `ionian`, `minor`, `aeolian`. (Ionian is the greek name for the major mode, and Aeolian is the greek mode corresponding to the minor mode.)

The default mode and key is C major.

The capo is meant to represent the potential capo position. Thus, if one were playing a song in C with a capo on the fifth fret, one would play the C as if it were an open G.

notes
=====

Note that going from Nashville Numbering to actual chords may not be all that useful! It might be better to leave the files in Nashville format, rendering them from there (i.e., retaining the I/IV/V).

In that case, don't bother with this program (although it's fairly neat, I think; it'd be useful for people who don't know their scales very well).

I've submitted a patch for chordii that handles Nashville Numbering gracefully (without warnings and without the chord grids). This may be more suitable if you prefer to preserve the Nashville numbering, which isn't a bad idea.

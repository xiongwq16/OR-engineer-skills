# !/usr/bin/env python
# -*- coding: utf-8 -*-

"""
    * @Description: code style
    * @Author: xiong
    * @Version: 1.0
    * @Since: python3.7
    * @Time: 2019-10-05
"""


class Foo:
    """Docstring for class foo."""

    #: Doc comment for class attribute foo.bar.
    #: It can have multiple lines.
    bar = 1

    flo = 1.5   #: Doc comment for foo.flo.

    baz = 2
    """
    Docstring for class attribute foo.baz,
    can be multi-lines.
    """

    def __init__(self, qux, spm):
        """
        构造函数
        :param qux: qux to be set
        :param spm: spm to be set
        """
        #: Doc comment for instance attribute qux.
        self.qux = qux

        """Docstring for instance attribute spam."""
        self.spam = spm

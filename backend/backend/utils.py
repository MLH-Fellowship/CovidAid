# utils.py -- meta stuff that gets used often

from flask import jsonify
import re


# The 'good' and 'bad' functions are just simple wrappers around
# 'jsonify' to return a fixed response. The 'bad' function's 'msg'
# parameter is mandatory. Can't have it just return 'status: error'.
# That would suck.
def good(msg=None, **kwargs):
    ret = kwargs
    ret["status"] = "OK"
    if msg is not None:
        ret["msg"] = msg
        return jsonify(ret)
    else:
        return jsonify(ret)


def bad(msg, **kwargs):
    ret = kwargs
    ret["status"] = "error"
    ret["msg"] = msg
    return jsonify(ret)


# Validate phone numbers using a generic regex for all international numbers.
def is_valid_number(phone):
    pattern = re.compile(
        "\+(9[976]\d|8[987530]\d|6[987]\d|5[90]\d|42\d|3[875]\d|2[98654321]\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\d{1,14}$"
    )
    return pattern.match(phone) is not None

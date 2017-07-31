
"""
自定义标签(过滤器)
"""

from django import template
from users.models import User

register = template.Library()


@register.filter(name='int2str')
def int2str(value):
    """
    int 转换为 str
    """
    return str(value)


@register.filter(name='bool2str')
def bool2str(value):
    if value:
        return u'是'
    else:
        return u'否'


@register.filter(name='id_to_name')
def id_to_name(user_id):
    try:
        user = User.objects.get(id=int(user_id))
        if user:
            return user.username
    except:
        return u'非法用户'


@register.filter(name='groups2str')
def groups2str(group_list):
    """
    将用户组列表转换为str
    """
    if len(group_list) < 3:
        return ' '.join([group.name for group in group_list])
    else:
        return '%s ...' % ' '.join([group.name for group in group_list[0:2]])

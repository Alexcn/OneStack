from django.db import models
from apps.common.models import BaseModel
from model_utils.fields import StatusField
# from model_utils import Choices


class Categories(BaseModel):
    name = models.CharField(max_length=32, unique=True)

    def categories_article_count(self):
        return self.wiki_set.all().count()


class Tag(BaseModel):
    name = models.CharField(max_length=32, unique=True)

    def tag_article_count(self):
        return self.wiki_set.all().count()


class Wiki(BaseModel):
    title = models.CharField(max_length=254, db_index=True)
    # author_id = models.IntegerField(default=1)
    content = models.TextField(max_length=5000)
    # STATUS = Choices('draft', 'published')
    # status = StatusField()
    # categories = models.ManyToManyField(Categories)
    # tag = models.ManyToManyField(Tag)

    class Meta:
        db_table = 'wikis'
        ordering = ['-created_at']
